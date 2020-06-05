"use strict";

(function() {
    fetch("http://localhost:9999/student/list")
        .then((response) => {
            if(response.ok) {
                return response.json();
            } else {
                return Promise.reject({ status: response.status, statusText: response.statusText });
            }
        })
        .then(students => {
            let content = "";
            students.forEach(function(stu, i) {
                content += `
              <tr>
                <th scope="row">${i+1}.</th>
                <td>${stu.studentNumber}</td>
                <td>${stu.firstName}</td>
<!--                <td>${new Intl.NumberFormat("en-US",{style:"currency",currency:"USD",minimumFractionDigits:2}).format(book.overdueFee)}</td>-->
                <td>${stu.middleName}</td>
                <td>${stu.lastName}</td>
                <td><a href="students/editBook.html?bookId=${book.bookId}">Edit</a></td>
                <td><a data-toggle="modal" data-bookid="${book.bookId}" data-bookisbn="${book.isbn}" data-booktitle="${book.title}" href="#confirmDeleteBookModal">Delete</a></td>
              </tr>
            `;
            });
            document.querySelector("#tbody").innerHTML = content;
        })
        .catch(err => {
            console.log("Error message:", err.statusText);
           // document.getElementById("divBooksList").innerHTML = "<p style='color:#ff0000;'>We are sorry. The elibrary books data service is unavailable. Please try again later</p>";
        });
})();
