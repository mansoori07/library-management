package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.MemberBook;
import com.example.library.model.Member;
import com.example.library.model.Transaction;
import com.example.library.repository.BookRepository;
import com.example.library.repository.MemberBookRepository;
import com.example.library.repository.MemberRepository;
import com.example.library.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final MemberBookRepository memberBookRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public String bookCheckout(Long bookId, Long memberId){

        try {
            //1st check member
            Member member = memberRepository.findById(memberId).orElse(null);
            if (member == null)
                return "Member with id " + memberId + " is not registered";
            log.info("Member checked : {}", member);

            //2nd check book
            Book book = bookRepository.findById(bookId).orElse(null);
            if (book == null)
                return "Book with id " + bookId + " is not present.";

            log.info("Book checked : {}", book);

            //3rd check memberbook
            MemberBook memberBook = memberBookRepository.findByMemberIdAndBookId(memberId, bookId);
            if (memberBook != null)
                return memberBook.getMember().getName() + " already have " + memberBook.getBook().getName() + "book.";
            log.info("MemberBook checked {}", memberBook);

            memberBook = new MemberBook();

            //update data
            updateData(book, member, memberBook, "checkout");

            log.info("/* --- After update data --- */ ");
            log.info("Book : {} \n\n Member : {} \n\n MemberBook : {}", book, member, memberBook);

            bookRepository.save(book);
            memberRepository.save(member);
            memberBookRepository.save(memberBook);
        } catch(Exception ex){
            log.error("{}", String.valueOf(ex));
            return "Failed with Exception";
        }
        return "SUCCESS";
    }

    //TODO: write for check in
    public void checkin(){
//        updateData(book, member, memberBook, "checkin");
    }

    private void updateData(Book book, Member member, MemberBook memberBook, String transact) {

        if(transact.equalsIgnoreCase("checkout")){
            book.setRemainingBooks(book.getRemainingBooks()-1);
            memberBook.setBook(book);
            memberBook.setMember(member);

            Transaction t = transactionRepository.save(new Transaction()
                    .setBookName(book.getName())
                    .setBookAuthor(book.getAuthor())
                    .setMemberName(member.getName())
                    .setMemberMobile(member.getPhoneNumber())
                    .setBorrowDate(new Date())
            );
            log.info("Book Transaction saved : {}", t);
        }
        else{
            book.setRemainingBooks(book.getRemainingBooks()+1);
            //delete memberrepo where book id,
        }

    }
/*
    private final BookRepository bookRepository;
    private final TransactionRepository checkoutRepository;

    public boolean bookTransaction(Long id, Member member){
        List<Book> books = new ArrayList<>();
        try{
            Book book = bookRepository.findById(id);
            if (book == null) {
                throw new NullPointerException("No book found for id : "+id);
            }
            books.add(book);
            log.info(books.toString());
            executeBookCheckout(books,member);
            return true;
        }catch (Exception e){
            log.error("{}", String.valueOf(e));
            return false;
        }
    }

    private void executeBookCheckout(List<Book> books, Member member) {
        //check if member already have book
        checkMembersBook(books, member);

        //check book availability
        checkBookAvailability(books);

        //update book count(i.e. decrease remaining book count by 1 for all the books)
        updateBookCount(books, false);

        member.setBooks(books);
        //createcheckout record
        List<Transaction> checkout = createCheckOutDetails(books, member);

        log.info("checkout {}", checkout);

        //save
//        checkoutRepository.saveAll(checkout);
        bookRepository.saveAll(books);

        //Generate pdf
//            byte[] pdf = CommonUtils.generatePDF(checkout);

        //save all the data
        bookRepository.saveAll(books);
//        checkoutRepository.saveAll(checkout);

        //send Notification
//            sendNotification()
    }

    public boolean bookCheckOut(List<Long> ids, Member member){
        try {
            //Fetch all books
            List<Book> books = new ArrayList<>();
            for(Long id:ids ) {
                Book book = bookRepository.findById(id);

                if (book == null) {
                    throw new NullPointerException("No book found for id : "+id);
                }
                books.add(book);
            }
            executeBookCheckout(books,member);
            return true;

        }catch(Exception e){
            log.error("{}", String.valueOf(e));
            return false;
        }

        

    }

    private void updateBookCount(List<Book> books, boolean bookReturn) {
        try{
            books.forEach(book -> {
                log.info("Before updateBookCount {}", book.getRemainingBooks());
                book.setRemainingBooks(bookReturn?
                    book.getRemainingBooks()+1 : book.getRemainingBooks()-1);
                log.info("After updateBookCount {}", book.getRemainingBooks());
            });
        } catch (Exception e) {
            log.error("{}", String.valueOf(e));
            throw new RuntimeException(e);
        }

    }

    private void checkBookAvailability(List<Book> books) {
        StringBuilder error = new StringBuilder();
        books.stream().filter(book -> book.getRemainingBooks()<=0)
                .forEach(book -> error.append(book.getName()).append(" is currently not available\n"));

        if(!error.isEmpty()) {
            log.info("errors = {}", error);
            throw new RuntimeException(error.toString());
        } else{
            log.info("checkBookAvailability = books are available");
        }
    }

    private void checkMembersBook(List<Book> books, Member member) {
        Set<String> bookSet = books.stream()
                .map(Book::getName)
                .collect(Collectors.toSet());

        log.info("bookSet = {}", bookSet);

        StringBuilder error = new StringBuilder();

        member.getBooks().stream().map(Book::getName)
                .filter(bookSet::contains)
                .forEach(book -> error.append(book).append(" is already checked out by ").append(member.getName()).append("\n"));

        log.info("member = {}", member);

        if(!error.isEmpty()) {
            log.info("error = {}", error);
            throw new RuntimeException(error.toString());
        }
    }


    private List<Transaction> createCheckOutDetails(List<Book> books, Member member) {
        List<Transaction> Transactions = new ArrayList<>();
        books.forEach(book -> {
            Transaction checkout = new Transaction()
                    .setBookName(book.getName())
                    .setBookAuthor(book.getAuthor())
                    .setMemberName(member.getName())
                    .setMemberEmail(member.getEmail())
                    .setBorrowDate(new Date());
            Transactions.add(checkout);
        });
        return Transactions;
    }

    */
}
