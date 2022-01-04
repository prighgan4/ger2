import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @Test
    void shouldCalculateRegistredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateRegistredAndBonusOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, true);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegistredFalseAndBonsUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, false);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegistredFalseAndBonusOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount =1000_000_60 ;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, false);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}