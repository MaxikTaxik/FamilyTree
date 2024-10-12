package Family_tree.save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
	public class FileHandler implements Writable {
    @Override
    public boolean save(Serializable object, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
        oos.writeObject(object);
        return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        

    @Override
    public Object read(String path) {
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path))) {
            return oos.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
