CREATE TABLE IF NOT EXISTS playlist_song_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
playlist_id INT NOT NULL,
song_id INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (playlist_id) REFERENCES playlists(id),
FOREIGN KEY (song_id) REFERENCES songs(id)
)