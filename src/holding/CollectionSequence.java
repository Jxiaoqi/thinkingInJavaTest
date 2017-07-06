package holding;

import java.util.AbstractCollection;
import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * Collection 和 Iterator p429
 * @author admin
 *
 */
public class CollectionSequence extends AbstractCollection<Pet>{

	private Pet[] pets = Pets.createArray(8);
	
	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < pets.length;
			}

			@Override
			public Pet next() {
				return pets[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public int size() {
		return pets.length;
	}
	
	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
		
		/**
		 * 0: Rat 1: Manx 2: Cymric 3: Mutt 4: Pug 5: Cymric 6: Pug 7: Manx 
			0: Rat 1: Manx 2: Cymric 3: Mutt 4: Pug 5: Cymric 6: Pug 7: Manx 
		 */
	}
	

}
