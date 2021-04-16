import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import CMainConstructions from "../components/CMainConstructions";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";

const Constructions = ({constructionData}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainConstructions getCon = {constructionData}/>
            <DClear />
            <EFooter />
        </div>
    );
};
export default Constructions;

export async function getStaticProps(context) {
    const response = await fetch('http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2/constructions');
    const constructionData = await response.json();
    console.log(constructionData);
    return {
        props: {constructionData}, // will be passed to the page component as props
    }
}