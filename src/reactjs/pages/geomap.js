import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import CMainGeoMap from "../components/CMainGeoMap";


const GeoMap = () => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainGeoMap />
            <DClear />
            <EFooter />
        </div>
    );
};

export default GeoMap;