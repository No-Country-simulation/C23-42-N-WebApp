CREATE TABLE IF NOT EXISTS reactions
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(15) NOT NULL,
icon VARCHAR(100) NOT NULL,
sound VARCHAR(100),
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
is_active TINYINT(1) DEFAULT 1,
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (song_id) REFERENCES comments(id)
)