import Headline from "./Headline";

const ConstructionById = (props) => {

    const construction = props.getById;

    return (
        <div id="c_main">
            <Headline />
            <h3>General information about id: {construction.id}</h3>
            <table align="center" border="1" cellPadding="5">
                <tr>
                    <td width="400px">Construction site - {construction.name}</td>
                    <td width="400px">code-number: {construction.codeNumber}</td>
                </tr>
            </table>
            <h3>Description:</h3>
            <table align="center">
                <td align="left" width="800px">{construction.description}</td>
            </table>
        </div>
    );
};

export default ConstructionById;

