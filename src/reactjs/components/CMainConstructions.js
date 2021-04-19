import Headline from "./Headline";
import Link from "next/link";

const Constructions = (props) => {

    return (
        <div id="c_main">
            <Headline />
            <table border="1" cellPadding="5">
                <tr>
                    <td width="100px">Database ID</td>
                    <td width="200px">CODE-NUMBER</td>
                    <td width="200px">Name of project</td>
                </tr>
                {props.getCon.map((construction) =>
                    <tr>
                        <td width="100px">{construction.id}</td>
                        <td width="200px">{construction.codeNumber}</td>
                        <td width="500px">
                            <Link href={`/constructions/${construction.id}`}>
                                <a>{construction.name}</a>
                            </Link>
                        </td>
                    </tr>
                )}
            </table>

            <h2>List of constructions:</h2>

        </div>
    );
};

export default Constructions;