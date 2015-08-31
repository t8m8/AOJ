main = do
    input <- getContents
    let (_:xss) = map words $ lines input :: [[String]]
    mapM_ putStrLn (map ans xss)

ans (x:y:z:_)
    | a*a == b*b + c*c = "YES"
    | b*b == c*c + a*a = "YES"
    | c*c == a*a + b*b = "YES"
    | otherwise = "NO"
    where a = read x
          b = read y
          c = read z