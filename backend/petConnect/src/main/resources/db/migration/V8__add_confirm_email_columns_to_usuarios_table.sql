ALTER TABLE usuarios
    ADD confirmation_token VARCHAR(255),
    ADD token_expiration DATETIME