
CREATE TABLE Bank (
    id integer PRIMARY KEY AUTOINCREMENT,
    title text UNIQUE NOT NULL,
    url text
);

CREATE TABLE Currency (
    id integer PRIMARY KEY AUTOINCREMENT,
    title text UNIQUE NOT NULL,
    code text UNIQUE NOT NULL
);

CREATE TABLE ExchangeRate (
    id integer PRIMARY KEY AUTOINCREMENT,
    bank_id integer NOT NULL,
    from_currency_id integer NOT NULL,
    to_currency_id integer NOT NULL,
    date text NOT NULL,
    min_rate float NOT NULL,
    max_rate float NOT NULL,

    FOREIGN KEY(bank_id) REFERENCES Bank(id),
    FOREIGN KEY(from_currency_id) REFERENCES Currency(id),
    FOREIGN KEY(to_currency_id) REFERENCES Currency(id)
);
