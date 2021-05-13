import AHeader from "../page_components/AHeader";
import BSideBar from "../page_components/BSideBar";
import CMainConstructions from "../page_components/CMainConstructions";
import DClear from "../page_components/DClear";
import EFooter from "../page_components/EFooter";
import React, { useContext, useState } from 'react'
import {ForGeoContext} from "../stores/store";

const Constructions = ({constructionsData}) => {
    const {constructionsx, updConstructions} = useContext(ForGeoContext);
    console.log(constructionsx);
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainConstructions getCon = {constructionsx} updCon = {updConstructions}/>
            <DClear />
            <EFooter />
        </div>
    );
};
export default Constructions;
