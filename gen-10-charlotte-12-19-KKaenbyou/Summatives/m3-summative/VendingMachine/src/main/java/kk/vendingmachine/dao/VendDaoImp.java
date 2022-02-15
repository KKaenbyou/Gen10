package kk.vendingmachine.dao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import kk.vendingmachine.dto.Vend;
import kk.vendingmachine.serv.NoItemEx;

public class VendDaoImp implements VendDao{
    
    public Map<String, Vend> vends = new HashMap<>();
    public static final String LIST_FILE = "inventory.txt";
    public static final String DELIMITER = ":";
    
    @Override
    public List<Vend> getAllVend() throws VendEx {
        loadList();
        return new ArrayList<Vend>(vends.values());
    }
    
    @Override
    public void boughtVend(String vend) throws VendEx {
        loadList();
        Vend updatedVend = vends.get(vend);
        updatedVend.setAmount(updatedVend.getAmount() - 1);
        writeList();
    }
    
    @Override
    public void daoChange(String vend, String money) throws VendEx, NoItemEx {
        loadList();
        Vend drinkChoice = vends.get(vend);
        System.out.println(Change.makeChange(drinkChoice.getPrice(), money));
    }
    
    @Override
    public Map<String, Vend> getVendMap() {
        return vends;
    }
    
    private void loadList() throws VendEx {
            Scanner scanner;
            try {
                scanner = new Scanner(new BufferedReader(new FileReader(LIST_FILE)));
            } catch (FileNotFoundException e) {
                throw new VendEx("Could not load Vend data into memory.", e);
            }
            String currentLine;
            Vend currentVend;
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentVend = unmarshallVend(currentLine);
                vends.put(currentVend.getVend(), currentVend);
            }
            scanner.close();
        }
    
    private Vend unmarshallVend(String VendAsText){
        String[] VendTokens = VendAsText.split(DELIMITER);
        String vend = VendTokens[0];
        Vend VendFromFile = new Vend(vend);
        VendFromFile.setPrice(VendTokens[1]);
        VendFromFile.setAmount(Integer.parseInt(VendTokens[2]));
        return VendFromFile;
    }
    
    private String marshallMP3(Vend vend){
        String VendAsText = vend.getVend() + DELIMITER;
        VendAsText += vend.getPrice() + DELIMITER;
        VendAsText += vend.getAmount();
        return VendAsText;
    }
    
    private void writeList() throws VendEx {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIST_FILE));
        } catch (IOException e) {
            throw new VendEx("Could not save Vend data.", e);
        }

        String VendAsText;
        List<Vend> vendList = this.getAllVend();
        for (Vend currentVend : vendList) {
            VendAsText = marshallMP3(currentVend);
            out.println(VendAsText);
            out.flush();
        }
        out.close();
    }
}