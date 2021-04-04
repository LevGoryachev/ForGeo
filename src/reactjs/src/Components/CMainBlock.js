import React from "react";
import Headline from "./Headline";

class CMainBlock extends React.Component {

    render() {
        return (
            <div id="c_main_block">
                <Headline />
                <h3>Content</h3>
                <h3>Service for construction site locations</h3>
            </div>
        );
    }
}

export default CMainBlock;