main = do
    n <- getLine
    print $ solve (read n :: Int) 100000

solve :: Int -> Int -> Int
solve n c
    | n == 0 = c
    | otherwise = solve (n-1) $ (ceiling $ (x+x*0.05)/1000)*1000 :: Int
    where x = fromIntegral c :: Double