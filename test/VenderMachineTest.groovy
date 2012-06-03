import spock.lang.Specification
import spock.lang.Unroll
/**
 * Created with IntelliJ IDEA.
 * User: toshi
 * Date: 12/06/02
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
class SpockTest extends Specification{

    @Unroll
    def "#money ‰~“Š“ü‚³‚ê‚½‚ç #expected ‰~•Ô‚·"(){
        given:
            def sut = new VendingMachine()
        expect:
            sut.in(money) == expected

        where:
            money   |expected
            1       |1
            100     |0
            5       |5
            1000    |0
            5000    |5000
    }

    @Unroll
    def "#money@‰~“Š“ü‚³‚ê‚½‚ç‡Œv‹àŠz‚ğ@#expected ‰~‚©‚¦‚·" () {
        given:
            def sut = new VendingMachine()
            sut.in(money)
        expect:

                expected == sut.getTotal()
        where:
            money   |expected
            10      |10
            1000    |1000
    }

    @Unroll
    def "æ‚É1000‰~“Š“ü‚µ‚Ä‚¢‚éê‡ #money@“Š“ü‚³‚ê‚½‚ç‡Œv‹àŠz‚ğ@#expected ‰~‚É‚È‚é" () {
        given:
            def sut = new VendingMachine()
            sut.in(1000)
            sut.in(money)

        expect:
            expected == sut.getTotal()

        where:
            money   |expected
            10      |1010
            100     |1100
            2000    |1000

    }

    @Unroll
    def "#money ‰~“Š“ü‚³‚ê‚Ä‚¢‚éê‡@•¥‚¢–ß‚µ‚ğ‚·‚é‚Æ #expected1 ‰~•Ô‚µ‡Œv‚ª #expected2 ‰~‚É‚È‚é"() {
        given:
            def sut = new VendingMachine()
            sut.in(100)
            sut.in(1000)
        expect:
            expected1 == sut.getChange()
            expected2 == sut.getTotal()

        where:
            money   |expected1      |expected2
            1100    |1100           |0
			
    }
}
