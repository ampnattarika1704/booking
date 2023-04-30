import java.util.Scanner;

class Book {
    private String name;
    private String number;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

class Booking {
    private String booking_name;
    private String booking_phone;
    private String getBooking_idCard;
    private String name;

    private Book book;

    public void setName(String name) {
        this.name = name;
    }

    public void setBooking_name(String booking_name) {
        this.booking_name = booking_name;
    }

    public void setBooking_phone(String booking_phone) {
        this.booking_phone = booking_phone;
    }

    public void setBooking_idCard(String getBooking_idCard) {
        this.getBooking_idCard = getBooking_idCard;
    }

    public void setBooking(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public String getBooking_name() {
        return booking_name;
    }

    public String getBooking_phone() {
        return booking_phone;
    }

    public String getGetBooking_idCard() {
        return getBooking_idCard;
    }

    public Book getBook() {
        return book;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] modes = {"แฟนซี", "โรแมน", "สยองขวัญ", "สืบสวน/อาชญากรรม", "แอคชั่น", "LGTBQ+", "คอมเมดี้", "ดราม่า", "ข้อคิด"};

        Book[] books;
        Booking[] booked;
        books = new Book[9*30];
        booked = new Booking[9*30];

        int num = 1;
        int index = 0;
        for (int i=0; i<9;i++){
            for(int j=0; j<30;j++){
                Book b_book = new Book();
                b_book.setName(modes[i]);
                String number = "";
                if (num < 10){
                    number = "00"+num;
                } else if (num < 100){
                    number = "0"+num;
                } else {
                    number = ""+num;
                }
                b_book.setNumber(number);
                books[index] = b_book;
                num++;
                index++;
            }
        }

        int index_booking = 0;
        while(true){
            System.out.println("1 : ยืม");
            System.out.println("2 : คืน");
            System.out.println("0 : ออก");
            System.out.print("เลือกเมนู : ");
            int menu = input.nextInt();

            if(menu == 1){
                for(int i=0; i<9; i++) {
                    System.out.println((i + 1) + " : " + modes[i]);
                }
                    System.out.print("เลือกโหมด : ");
                    int mode = input.nextInt();
                    int end = mode * 30;
                    int start = end - 30;
                    for (int j=0;j<30;j++){
                        System.out.println(books[start+j].getNumber() + " : " + books[start+j].getName());
                    }
                    System.out.print("กรอกเลขหนังสือ : ");
                    input.nextLine();
                    String input_number = input.nextLine();
                    System.out.print("ชื่อผู้ยืม : ");
                    String input_bookingName = input.nextLine();
                    System.out.print("เบอร์โทรผู้ยืม : ");
                    String input_bookingPhone = input.nextLine();
                    System.out.print("เลขบัตรประชาชนผู้ยืม : ");
                    String input_bookingIdCard = input.nextLine();
                    System.out.print("ชื่อผู้รับผิดชอบให้ยืม : ");
                    String input_Name = input.nextLine();

                    int check = 0;
                    for (int x=0; x<9*30;x++){
                        if((books[x].getNumber()).equals(input_number)){
                            Booking booking = new Booking();
                            booking.setName(input_Name);
                            booking.setBooking_name(input_bookingName);
                            booking.setBooking_phone(input_bookingPhone);
                            booking.setBooking_idCard(input_bookingIdCard);
                            booking.setBooking(books[x]);
                            booked[index_booking] = booking;
                            check = 1;
                            index_booking++;
                            break;
                        }
                    }
                    if(check == 1){
                        System.out.println("หนังสือเล่มนี้ถูกยืม");
                    } else {
                        System.out.println("ไม่มีเลขหนังสือเล่มนี้");
                    }
            } else if (menu == 2){
                for(int i=0; i<9; i++) {
                    System.out.println((i + 1) + " : " + modes[i]);
                }
                System.out.print("เลือกโหมด : ");
                int mode = input.nextInt();
                int end = mode * 30;
                int start = end - 30;
                for (int j=0;j<30;j++){
                    System.out.println(books[start+j].getNumber() + " : " + books[start+j].getName());
                }
                input.nextLine();
                System.out.print("กรอกเลขหนังสือ : ");
                String input_number = input.nextLine();


                int check = 0;
                for (int x=0; x<index_booking;x++){
                    if(((booked[x].getBook()).getNumber()).equals(input_number)){
                        check = 1;
                        index_booking--;
                        break;
                    }
                }
                if(check == 1){
                    System.out.println("หนังสือเล่มนี้ถูกคืนแล้ว");
                } else {
                    System.out.println("ไม่มีเลขหนังสือเล่มนี้");
                }
            } else if (menu == 0){
                System.out.println("ออก!");
                break;
            } else {
                System.out.println("กรอกอีกครั้ง!");
            }

        }



    }
}