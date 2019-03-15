package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public interface Iatm {
   public int getCurrentBalance();
   public void withdraw(int amount);
   public void deposit(int amount);
   public void prev();
   public void next();
}
