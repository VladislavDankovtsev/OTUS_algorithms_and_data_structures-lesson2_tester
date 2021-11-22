package lesson2;

import lesson2.string.TaskString;
import lesson2.tester.Tester;
import lesson2.tickets.TaskTickets;

public class Program {
    public static void main(String[] args) {
        ITask task = new TaskTickets();
        Tester tester = new Tester(
                task,"/Users/vidankov/Desktop/otus/lesson2/A01_Счастливые_билеты-1801-057a77/1.Tickets");
        tester.RunTests();
    }
}
