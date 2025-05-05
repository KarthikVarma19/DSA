with stocks_table_buy (stock_name, total_loss) AS
    (SELECT 
    s.stock_name,
    SUM(price)
    from
    Stocks s
    WHERE s.operation = 'Buy'
    GROUP BY s.stock_name), 

    stocks_table_sell (stock_name, total_profit) AS
    (SELECT 
    s.stock_name,
    SUM(price)
    from
    Stocks s
    WHERE s.operation = 'Sell'
    GROUP BY s.stock_name)


SELECT 
stb.stock_name,
(sts.total_profit - stb.total_loss) as capital_gain_loss
FROM 
stocks_table_buy stb
JOIN 
stocks_table_sell sts
ON stb.stock_name = sts.stock_name;