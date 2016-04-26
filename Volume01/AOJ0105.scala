import java.util.Scanner
import scala.collection.mutable._
import scala.math.Ordering.Implicits._

object AOJ0105 {

	def main(args: Array[String]): Unit = {
		val in = new Scanner(System.in)

		val map = Map.empty[String, List[Int]]
		while (in.hasNext) {
			var s = in.next
			var p = in.nextInt

			if (map.contains(s)) {
				map.put(s, p::map.get(s).get)
			} else {
				map.put(s, List(p))
			}
		}

		var outer = ListBuffer.empty[(String, List[Int])]
		map.foreach { item =>
			outer += item
		}
		outer = outer.sortWith(_ < _)

		outer.foreach { case (s, p) =>
			println(s)
			val pl = p.sorted
			pl.foreach { i =>
				if (i == pl.last){
					println(i)
				} else {
					print(i+" ")
				}
			}
		}
	}
}