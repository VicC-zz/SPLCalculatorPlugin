package edu.bth.spla.calculator;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**Clase encargada de crear el registro de imagenes que es usado
 * por el plugin para hacer la carga de las imagenes en tiempo
 * de ejecucion*/
public class ImagesMgr {
	
	public static final String CHECKED_IMAGE = "checked.gif";

	public static final String UNCHECKED_IMAGE = "unchecked.gif";
	
	public static final String LEAF_IMAGE = "leaf.jpg";

	private static final String IMAGES_DIR = "images/";
	
	/**Crea el regstro de imagenes y adiciona las imagenes que
	 * seran utilizadas dentro del plugin*/
	public static ImageRegistry create(String pluginID) {
		ImageRegistry imageRegistry = new ImageRegistry();
		
		imageRegistry.put(CHECKED_IMAGE, AbstractUIPlugin
				.imageDescriptorFromPlugin(pluginID,
						IMAGES_DIR + CHECKED_IMAGE));

		imageRegistry.put(UNCHECKED_IMAGE, AbstractUIPlugin
				.imageDescriptorFromPlugin(pluginID,
						IMAGES_DIR + UNCHECKED_IMAGE ));
		
		imageRegistry.put(LEAF_IMAGE, AbstractUIPlugin
				.imageDescriptorFromPlugin(pluginID,
						IMAGES_DIR + LEAF_IMAGE ));
		
		return imageRegistry;

	}
}
