public class Formatter {
    public String format(double price) {
        int count = (int) price;
        String currency;
        int lastTwoCharacter = count % 100;
        if (lastTwoCharacter >= 11 && lastTwoCharacter < 15) {
            currency = "рублей";
        } else {
            int lastCharacter = count % 10;
            switch (lastCharacter) {
                case 1:
                    currency = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    currency = "рубля";
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                default:
                    currency = "рублей";
                    break;
            }
        }
        return String.format("%.2f " + currency, price);
    }
}
