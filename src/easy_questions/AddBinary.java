package easy_questions;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        boolean hasCarry = false;
        while (aIdx >= 0 && bIdx >= 0) {
            char aChar = a.charAt(aIdx);
            char bChar = b.charAt(bIdx);
            aIdx--;
            bIdx--;
            if (aChar == '1' && bChar == '1') {
                if (hasCarry) {
                    System.out.println("HWL");
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                }
                hasCarry = true;
                continue;
            }

            if (aChar == '1' || bChar == '1') {
                if (hasCarry) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
                continue;
            }

            if (hasCarry) {
                sb.insert(0, '1');
                hasCarry = false;
            } else {
                sb.insert(0, '0');
            }
        }

        for (; aIdx >= 0; aIdx--) {
            char aChar = a.charAt(aIdx);
            if (aChar == '1') {
                if (hasCarry) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
                continue;
            }

            if (hasCarry) {
                sb.insert(0, '1');
                hasCarry = false;
            } else {
                sb.insert(0, '0');
            }
        }

        for (; bIdx >= 0; bIdx--) {
            char bChar = b.charAt(bIdx);
            if (bChar == '1') {
                if (hasCarry) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
                continue;
            }

            if (hasCarry) {
                sb.insert(0, '1');
                hasCarry = false;
            } else {
                sb.insert(0, '0');
            }
        }

        if (hasCarry) {
            sb.insert(0, '1');
        }
        
        return sb.toString();
    }
}
