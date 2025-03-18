-- Create the User table
CREATE TABLE "users" (
                        id BIGSERIAL PRIMARY KEY,              -- Auto-incrementing primary key
                        username VARCHAR(255) UNIQUE NOT NULL, -- Unique username
                        fullname VARCHAR(255) UNIQUE NOT NULL, -- Unique username
                        password VARCHAR(255) NOT NULL,       -- Hashed password
                        street VARCHAR(255) NOT NULL,       -- Hashed password
                        city VARCHAR(255) NOT NULL,       -- Hashed password
                        state VARCHAR(255) NOT NULL,       -- Hashed password
                        zip VARCHAR(255) NOT NULL,       -- Hashed password
                        phone_number VARCHAR(255) NOT NULL       -- Hashed password
                      --  role VARCHAR(50) NOT NULL             -- User role (e.g., ROLE_USER, ROLE_ADMIN)
);

-- Optional: Add an index on the username column for faster lookups
CREATE INDEX idx_user_username ON "users" (username);
