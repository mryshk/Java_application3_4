DROP TABLE IF EXISTS post;

CREATE TABLE post(
    id int AUTO_INCREMENT PRIMARY KEY,
    user_id int,
    music_name VARCHAR(100) NOT NULL,
    artist_name VARCHAR(100) ,
    genre int NOT NULL,
    caption VARCHAR(255) NOT NULL,
    created DATE,
    FOREIGN KEY(user_id) REFERENCES users.id
 );
 
 
 
