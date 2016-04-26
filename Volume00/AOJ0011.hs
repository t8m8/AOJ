import Control.Monad
import Control.Applicative

main = do
    w <- readLn
    n <- readLn
    q <- replicateM n $ words<$>translate<$>getLine
    mapM_ print $ solve [1..w] [(swap a b) | (x:y:_) <- q, let a = read x :: Int, let b = read y :: Int]

solve xs [] = xs
solve xs (f:fs) = solve (f xs) fs

swap i j xs = map f (zip [1..] xs)
    where f (idx, x) | idx == i = xs !! (j-1)
                     | idx == j = xs !! (i-1)
                     | otherwise = x

translate :: String -> String
translate [] = []
translate (x:xs)
    | x == ',' = ' ' : translate xs
    | otherwise = x : translate xs