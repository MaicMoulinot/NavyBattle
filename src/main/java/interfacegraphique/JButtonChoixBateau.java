/**
 * 
 */
package interfacegraphique;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author humanbooster
 *
 */
@SuppressWarnings("serial")
public class JButtonChoixBateau extends JButtonGrille {

	/**
	 * Constructeur.
	 */
	public JButtonChoixBateau(int positionHorizontale, int positionVerticale) {
		super(positionHorizontale, positionVerticale);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseExited(MouseEvent e) {
				if (isPlaced()) {
					setColorPlaced();
				} else {
					setColorUnplayed();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setColorOnMouseOver();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			} 

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

		});
	}
}
