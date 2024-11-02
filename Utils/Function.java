/**
 *
 */
package OOP_End.Utils;


public class Function {

    public static boolean isEmpty(String value) {
        return value.equals("");
    }

    public static boolean isTrueNumber(String number) {
        if (isEmpty(number))
            return false;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHasSpace(String value) {
        if (isEmpty(value))
            return false;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ' ') {
                return true;
            }

        }
        return false;
    }

    public static boolean isTrueEmail(String email) {
        if (isEmpty(email) || isHasSpace(email))
            return false;
        else {
            if (Character.isDigit(email.charAt(0)) || email.charAt(0) < 'A' || (email.charAt(0) > 'Z' && email.charAt(0) < 'a') || email.charAt(0) > 'z') {
                return false;
            }
            int countEmail = 0;
            int countChr = 0;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    countEmail++;
                }
                if (email.charAt(i) == '.') {
                    countChr++;
                }
            }
            return countEmail == 1 && countChr == 1;
        }
    }

    public static boolean isTrueDate(String date) {
        String[] index = date.split("/");
        if (index.length < 2)
            return false;
        else {
            if (isTrueNumber(index[0]) && isTrueNumber(index[1]) && isTrueNumber(index[2])) {
                int day = Integer.parseInt(index[0]);
                int month = Integer.parseInt(index[1]);
                int year = Integer.parseInt(index[2]);

                // Kiểm tra
                // Do năm nay là 2024 nên độ tuổi về hưu sẽ là 52 tuổi 8 tháng (làm tròn 53
                // tuổi)
                // Nên tuổi có thể đi làm sẽ trong khoảng 1972 đến 2008
                if (year > 1972 && year < 2008) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                            || month == 12) {
                        if (day < 0 || day > 31)
                            return false;
                    } else if (month == 4 || month == 6 || month == 0 || month == 11) {
                        if (day < 0 || day > 30)
                            return false;
                    } else if (month == 2) {
                        if (year % 4 == 0) {
                            if (day < 0 || day > 29)
                                return false;
                        } else {
                            if (day < 0 || day > 28)
                                return false;
                        }
                    } else
                        return false;
                } else
                    return false;
            } else
                return false;
        }
        return true;
    }

    public static String normalizeName(String name) {
        String result = "";
        String[] arrName = name.split("\\s+");
        for (String str : arrName) {
            result += str.toUpperCase().charAt(0);
            for (int i = 1; i < str.length(); i++) {
                result += str.toLowerCase().charAt(i);
            }
            result += " ";
        }
        return result.trim();
    }

    public static boolean hasVietnameseAccent(String value) {
        return value.matches(".*[ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯẠ-ỹ].*");
    }

}
