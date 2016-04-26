import Data.List
import Control.Monad
import Control.Applicative

main = do
    input <- getContents
    let xs = sort $ map (read :: String -> Int) $ lines input :: [Int]
    print $ xs !! (length xs -1)
    print $ xs !! (length xs -2)
    print $ xs !! (length xs -3)