"use strict";


function Book (bookname, booksubject, bookpages, bookisbn) {
    this.bookname = bookname;
    this.booksubject = booksubject;
    this.bookpages = bookpages;
    this.bookisbn = bookisbn;
    
    this.getBookInfo = function () {
        console.log("Book: " + this.bookname);
        console.log("Topic: " + this.booksubject);
        console.log("Pages: " + this.bookpages);
        console.log("ISBN: " + this.bookisbn);
        console.log("-----");
    }
}


let books = [];

books.push(new Book("omeganame", "omegatitle", 400, 4325345));
books.push(new Book("lolname", "loltitle", 500, 211211));
books.push(new Book("lulname", "lultitle", 600, 999999));


let numberOfBooks = prompt("Hur många böcker vill du lägga till?");

while (numberOfBooks >0) {
    let addBookName = prompt("Namn på bok:");
    let addBookSubject = prompt("Vad handlar boken om:");
    let addPages = prompt("Hur många sidor har boken:");
    let addISBN = prompt("Vad är boken ISBN");
    books.push(new Book(addBookName, addBookSubject, addPages, addISBN));
    numberOfBooks--;
}


books.forEach(function (printa) {
        printa.getBookInfo();
    }
);



