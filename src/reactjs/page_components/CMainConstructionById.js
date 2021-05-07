import Headline from "./Headline";

const cMainConstructionById = (props) => {

    const construction = props.getById;

    return (
        <div id="c_main">
            <Headline />
            <h3>Construction site (id: {construction.id})</h3>
            <table className="maintable">
                <thead>
                    <tr>
                        <td><h3>Code-number</h3></td>
                        <td><h3>Name (project or construction site name)</h3></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td width="400px">Construction site - {construction.name}</td>
                        <td width="400px">code-number: {construction.codeNumber}</td>
                    </tr>
                </tbody>
            </table>
            <table className="maintable">
                <thead>
                    <tr>
                        <td><h3>Description</h3></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td align="left" width="800px">{construction.description}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default cMainConstructionById;

