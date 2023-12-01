package Day01
import scala.io.Source
object Main extends App {
  // Hello !
  val source: Source = Source.fromFile("res/Day01/input.txt")
  val inputs: Array[String] = source.getLines().toArray
  source.close()

  var sum: Int = 0
  for(input <- inputs){
    val firstDigit: String = findFirstNumberInLetter(input)
    val lastDigit: String = findFirstNumberInLetter(input.reverse,true)

    sum += Integer.parseInt(firstDigit + lastDigit)
  }
  println(sum)



  def findFirstNumberInLetter(wrd:String,reversed:Boolean = false):String = {
    var numbers : Array[String] = Array[String]("one","two","three","four","five","six","seven","eight","nine")
    val numbersReversed: Array[String] = numbers.map((x: String) => x.reverse)
    numbers = if(reversed) numbersReversed else numbers
    var lowestLetterNumberIndex: Int = Int.MaxValue
    var lowestLetterNumber: String = ""
    for(number: String <- numbers){
      val numberIndex: Int = wrd.toLowerCase().indexOf(number)
      if(numberIndex != -1 && numberIndex < lowestLetterNumberIndex){
        lowestLetterNumberIndex = numberIndex
        lowestLetterNumber = number
      }
    }

    var lowestDigitIndex: Int = Int.MaxValue
    var lowestDigit: String = ""
    for(i: Int <- 0 to 9){
      val digitIndex: Int = wrd.indexOf(i.toString)
      if (digitIndex != -1 && digitIndex < lowestDigitIndex) {
        lowestDigitIndex = digitIndex
        lowestDigit = i.toString
      }
    }
    println(s" Word : $wrd lowest Digit : $lowestDigit lowest Letter Number $lowestLetterNumber" )

    if(lowestLetterNumberIndex < lowestDigitIndex) {
      if (reversed){
        lowestLetterNumber = lowestLetterNumber.reverse
      }
      lowestLetterNumber match{
        case "one" => return "1"
        case "two" => return "2"
        case "three" => return "3"
        case "four" => return "4"
        case "five" => return "5"
        case "six" => return "6"
        case "seven" => return "7"
        case "eight" => return "8"
        case "nine" => return "9"
      }
    }else{
      return lowestDigit
    }
  }
}
