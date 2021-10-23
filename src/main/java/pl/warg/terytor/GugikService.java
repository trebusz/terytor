package pl.warg.terytor;

import lombok.extern.slf4j.Slf4j;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.feature.FeatureCollection;
import org.opengis.feature.Feature;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.spatial.Contains;
import pl.warg.terytor.util.TercUtil;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class GugikService {

	private FeatureSource featureSource;

	public GugikService(String communeBordersShpFilePath) {
		loadData(communeBordersShpFilePath);
	}

	private void loadData(String communeBordersShpFilePath) {

		try {
			File file = new File(communeBordersShpFilePath);
			DataStore dataStore = DataStoreFinder.getDataStore(Collections.singletonMap("url", file.toURI().toString()));
			String[] typeNames = dataStore.getTypeNames();
			String dataStoreTypeName = typeNames[0];
			featureSource = dataStore.getFeatureSource(dataStoreTypeName);

		} catch (Exception e) {
			throw new RuntimeException("Could not setup GugikService", e);
		}
	}

	public boolean isGivenLatLonInProvidedTercUnit(double lat, double lon, String tercCode) {

		String point = "Point(" + lon + " " + lat + ")";

		if (!TercUtil.isTercCodeValid(tercCode)) {
			throw new RuntimeException(tercCode + " is not valid terc code");
		}

		tercCode = tercCode.substring(0, 6); // ignoring RODZ, probably makes sense

		try {

			FilterFactory2 filerFactory2 = CommonFactoryFinder.getFilterFactory2();
			Contains contains = filerFactory2.contains(
					filerFactory2.property(featureSource.getSchema().getGeometryDescriptor().getLocalName()),
					filerFactory2.literal(point));

			FeatureCollection collection = featureSource.getFeatures(contains);

			if (collection.size() > 0) {

				if (collection.size() > 1) {
					log.warn(point + " seem to be inside multiple units(?)");
				}

				Feature simpleFeature = (Feature) collection.toArray()[0];
				String featureTercCode = simpleFeature.getProperty("JPT_KOD_JE").getValue().toString().substring(0, 6);

				if (tercCode.equals(featureTercCode)) {
					return true;
				} else {
					log.debug(point + " is inside " + featureTercCode + ", not in " + tercCode);
					return false;
				}
			} else {
				throw new RuntimeException("" + point + " don't seem to be inside the borders");
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not check if " + point + " is in " + tercCode, e);
		}
	}
}
