import React from "react";
import './App.css';
import AHeader from "./Components/AHeader";
import BSideBar from "./Components/BSideBar";
import EFooter from "./Components/EFooter";
import CMainBlock from "./Components/CMainBlock";
import DClear from "./Components/DClear";

class App extends React.Component {

    render() {
        return (
            <div id="container">
                <AHeader />
                <BSideBar />
                <CMainBlock />
                <DClear />
                <EFooter />
            </div>
        );
    }
}

export default App;
