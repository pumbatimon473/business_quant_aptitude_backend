-- Create Database:
create database business_quant;
use business_quant;

-- Create Table:
create table if not exists stocks (
                                      id bigint primary key auto_increment,
                                      ticker varchar(10),
                                      date date,
                                      revenue double,
                                      gp double,
                                      fcf double,
                                      capex double
);

desc stocks;
drop table if exists stocks;

-- Loading data from CSV
load data infile "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sample-Data-Historic.csv"
    into table stocks
    fields terminated by ',' optionally enclosed by '"'
    lines terminated by '\r\n'
    ignore 1 lines(ticker, @datestr, @revenue, @gp, @fcf, @capex)
    -- substring_index(@datestr, '/', 2) = mm_dd
    set date = concat(right(@datestr, 4), '-', substring_index(@datestr, '/', 1), '-', substring_index(substring_index(@datestr, '/', -2), '/', 1))
        , revenue = if(length(@revenue) = 0, null, @revenue)
        , gp = if(length(@gp) = 0, null, @gp)
        , fcf = if (length(@fcf) = 0, null, @fcf)
        , capex = if (length(@capex) = 0, null, @capex);

select * from stocks;
delete from stocks;

select * from stocks
where ticker = 'AAPL';

-- Index on table:
show index from stocks;

-- Creating Index
-- 1. index on ticker col
alter table stocks add index ticker_idx (ticker);
drop index ticker_idx on stocks;

-- 2. multi-column index
alter table stocks add index ticker_date_idx (ticker, date);


-- COMPARE:
select cast(-61907565.81 as decimal(16, 2));