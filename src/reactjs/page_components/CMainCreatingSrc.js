



const CMainCreatingSrc = () => {

    const {constructionsx, updConstructions} = useContext(ForGeoContext);

    const [constructionsxState, updConstructionsState] = useState(constructionsx);

    //const [loading, setLoading] = useState(false);

    /*useEffect(() => {
        setLoading(true);
        CRUDconstructions.getAll()
            .then((x) => {
                updConstructionsState(x);
            })
            .then((y) => console.log(y))
            .catch((err) => {
                console.log(err);
            })
            .finally(() => {
                setLoading(false);
            });

    }, []);

    if (loading) {
        return (
        <div id="c_main">
            <Headline />
            <p>Data is loading...</p>;
        </div>
        )
    }*/

        const { register, handleSubmit } = useForm();

        //const onSubmit = data => console.log('xyz');


        function onSubmit(data) {
           CRUDconstructions.create(data)
                .then((x) => {
                    updConstructionsState(x);
                })
                .then((x) => console.log(x))
                .catch((err) => {
                    console.log(err);
                });

            //console.log(data);
            console.log('abcde');
            //window.location.href='/constructions'

        }



        return (
            <div id="c_main">
                <Headline />

                <form onSubmit={handleSubmit(onSubmit)}>

                        <input title="ID" name="name" ref={register} placeholder="Name"/>
                        <input title="Code-Number of construction" name="codeNumber" ref={register} placeholder="Code-number"/>
                        <input title="Description" type="text" name="description" ref={register} placeholder="Description"/>
                    <input type="submit" />

                    {/*<h3>Set general information about the construction site:</h3>
                    <table align="center" border="1" cellPadding="5">
                        <tr>
                            <td width="400px"><input title="ID" name="name" defaultValue="testName" ref={register} placeholder="Name"/></td>
                            <td width="400px"><input title="Code-Number of construction" name="codeNumber" defaultValue="testCN" ref={register} placeholder="Code-number"/></td>
                        </tr>
                    </table>
                    <h3>Description:</h3>
                    <table align="center" border="1" cellPadding="5">
                        <td align="left" width="820px"><input title="Description" type="text" name="description" defaultValue="testD" ref={register} placeholder="Description"/></td>

                    </table>

                    <button type="submit">Submit</button>*/}
                </form>
            </div>
        );

    /*return (
        <div id="c_main">
            <Headline />
            {/!*<p>{language}</p>*!/}

            <table border="1" cellPadding="5">
                <tr>
                    <td width="100px">Database ID</td>
                    <td width="200px">CODE-NUMBER</td>
                    <td width="200px">Name of project</td>
                    <td colSpan="2">EDIT DATA</td>
                </tr>
                {constructionsxState.map((construction) =>
                    <tr>
                        <td width="100px">{construction.id}</td>
                        <td width="200px">{construction.codeNumber}</td>
                        <td width="500px">
                            <Link href={`/constructions/${construction.id}`}>
                                <a>{construction.name}</a>
                            </Link>
                        </td>
                        <td>
                            <button onClick={() => {constructionDel(construction.id)
                                .then(() => {
                                CRUDconstructions.getAll()
                                    .then((x) => {
                                        updConstructionsState(x);
                                    })
                                    .then((y) => console.log(y))
                                    .catch((err) => {
                                        console.log(err);
                                    });
                                //window.location.href='/constructions'
                            });}}>DELETE</button>
                        </td>

                    </tr>
                )}

                {/!*<tr>

                        <td > {const nameInput = () = {<input title="ID" type="text" const name="name"></input>}}</td>
                        <td ><input title="ID" type="text" name="codeNumber"></input></td>
                        <td ><input title="ID" type="text" name="description"></input></td>

                        <td colSpan="2"><input type="submit" value="ADD" onSubmit={() => {CRUDconstructions.create().then(() => {
                            window.location.href='/constructions';
                            console.log(nameInput);
                        });}}/></td>

                </tr>*!/}
            </table>
        </div>
    );*/

};
