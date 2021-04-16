import {useRouter} from "next/router";

export default function Construction({construction}) {
    const {query} = useRouter()
    return (
            <div id = "construction">
                <h1>Construction id: {query.id}, code-number: {construction.codeNumber}</h1>
                <p>code-number: {construction.codeNumber}</p>
                <p>name: {construction.name}</p>
                <p>description: {construction.description}</p>
            </div>
    )
};

export async function getServerSideProps({params}) {
    const response = await fetch(`http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2/constructions/${params.id}`)
    const construction = await response.json()
    console.log(params);
    return {
        props: {construction}, // will be passed to the page component as props
    }
}