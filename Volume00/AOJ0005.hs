main = do
    input <- getContents
    let xss = map ((map read).words) $ lines input :: [[Int]]
    mapM_ putStrLn [show (gcd a b) ++ " " ++ show (lcm a b)| xs <- xss, let a = xs !! 0, let b = xs !! 1]
