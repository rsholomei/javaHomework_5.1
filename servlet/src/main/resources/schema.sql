CREATE TABLE GuestBook(
                GuestBook_ID   INT NOT NULL AUTO_INCREMENT,
                NameGuest VARCHAR (255) NOT NULL,
                Message VARCHAR (255) NOT NULL,
                Rating INT (20) NOT NULL,
                PRIMARY KEY (GuestBook_ID)
        );