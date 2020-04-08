package inventory;

import database.Database;
import database.sql2o.Container;
import database.sql2o.Pallet;
import database.sql2o.Part;
import database.sql2o.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PalletInventory {

    private Database db;

    public PalletInventory(Database db){
            this.db = db;
    }

    public boolean purchasePallet(int numBoxes, String warehouse_loc){
        String pallet_id = UUID.randomUUID().toString();
        Pallet newPallet = new Pallet(pallet_id,warehouse_loc);
        db.getPalletInventoryTable().addPallet(newPallet);
        for(int i = 0; i<numBoxes;i++){
            String container_id = UUID.randomUUID().toString();
            Container newContainer = new Container(container_id,warehouse_loc,pallet_id);
            db.getContainerInventoryTable().addContainer(newContainer);
        }
        return true;
    }

    public void deployPallet(String pallet_id){
        //TODO: Remove pallet, its boxes, and its parts/products from inventory
        //This will eventually send a call to th  Inventory silo
    }

    public List<PalletView> getPalletViews(){
        List<PalletView> palletViews = new ArrayList<>();
        List<Pallet> pallets = db.getPalletInventoryTable().getAllPallets();

        for(Pallet p : pallets){
            PalletView palletView = new PalletView(p.getSerial_num(), p.getWarehouse_loc());
            List<Container> palletsContainers = db.getContainerInventoryTable().getPalletsContainers(p.getSerial_num());
            for(Container c : palletsContainers){
                String type = "Empty";
                String id = c.getSerial_num();
                int numberOfItems = 0;
                List<Product> products = db.getProductInventoryTable().getContainersProducts(id);
                if(products.size()>0){
                    numberOfItems = products.size();
                    type = "Products";
                }
                else{
                    List<Part> parts = db.getPartInventoryTable().getContainersParts(id);
                    if(parts.size()>0){
                        numberOfItems = parts.size();
                        type = "Parts";
                    }
                }
                BoxView box = new BoxView(id,type,numberOfItems);
                palletView.addBox(box);
            }
            palletViews.add(palletView);
        }
        return palletViews;
    }
}
