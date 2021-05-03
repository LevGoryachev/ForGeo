import AHeader from "../page_components/AHeader";
import BSideBar from "../page_components/BSideBar";
import DClear from "../page_components/DClear";
import EFooter from "../page_components/EFooter";
import CMainGeoMap from "../page_components/CMainGeoMap";
import {CRUDlocations} from "../service_components/CRUDLocations";

const GeoMap = ({geoLocData}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainGeoMap getLoc = {geoLocData} />
            <DClear />
            <EFooter />
        </div>
    );
};
export default GeoMap;

export async function getStaticProps(context) {
    const geoLocData = await CRUDlocations.getAll();
    console.log(geoLocData);
    return {
        props: {geoLocData}, // will be passed to the page component as props
    }
}