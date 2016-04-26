import Control.Applicative

main = do
    input <- getContents
    let xss = map words $ lines input :: [[String]]
    mapM_ print [length (show(a+b)) | xs <- xss, let a = read (xs !! 0) :: Int, let b = read (xs !! 1) :: Int]