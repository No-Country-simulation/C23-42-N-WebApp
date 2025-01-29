CREATE TABLE IF NOT EXISTS user_last_played_song_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
song_id INT NOT NULL,
paused_at_second INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (song_id) REFERENCES songs(id)
)