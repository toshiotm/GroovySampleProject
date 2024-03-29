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
    def "#money 円投入されたら #expected 円返す"(){
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
    def "#money　円投入されたら合計金額を　#expected 円かえす" () {
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
    def "先に1000円投入している場合 #money　投入されたら合計金額を　#expected 円になる" () {
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
    def "#money 円投入されている場合　払い戻しをすると #expected1 円返し合計が #expected2 円になる"() {
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
