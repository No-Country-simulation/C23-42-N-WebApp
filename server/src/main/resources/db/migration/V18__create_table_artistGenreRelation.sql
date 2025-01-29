CREATE TABLE IF NOT EXISTS artist_genre_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
artist_id INT NOT NULL,
genre_id INT NOT NULL,
FOREIGN KEY (artist_id) REFERENCES artists(id),
FOREIGN KEY (genre_id) REFERENCES genres(id)
)