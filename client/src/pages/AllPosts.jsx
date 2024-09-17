import Header from "../components/Header";
import { useEffect , useState} from "react";
import { getAllPosts } from "../services/api";
import {Box,InputBase,Button, Typography, Card, CardContent,styled} from "@mui/material"
import {Search as SearchIcon} from '@mui/icons-material';

const SearchContainer = styled(Box)({
    marginTop:74,
    display : 'flex',
    justifyContent : 'center',
    '& > div': {
        width: 500,
        height: 45,
        border: '1 px solid #767676',
        borderRadius:10,
        display:'flex',
        alignItems: 'center',
        marginRight: 20,
        paddingleft: 10
        },
    '& > div > div' : {
        width: '85%',
        margin: '0 20px'
    }

})

const FindButton = styled(Button)({
    background: '#2557a7',
    textTransform: 'none',
    height : 45,
    borderRadius: 10,
    width : 100
})

const PostWrapper = styled(Box)({
    display : 'flex',
    justifyContent: 'center',
    marginTop: 50,
    flexWrap: 'wrap',
    '& > div' : {
        border: '1px solid #d4d2d0',
        borderRadius:10,
        margin: 10,
        width: '30%',
        height: 300
    }
})

const AllPosts = () => {

    const [posts, setPosts] = useState([]);
    const [text, setText] = useState("");
    useEffect(() =>{
        const getData = async()=>{
            const response  = await getAllPosts();
            setPosts(response.data);
        }
        getData();
    },[])

    return (
        <>
            <Header/>

            <SearchContainer>
                <Box>
                <InputBase
                    placeholder = "Search by Job Title"
                    onChange= {(e)=> setText(e.target.value)}
                />
                <SearchIcon/>
                </Box>
                <FindButton variant="contained">Find Jobs</FindButton>
            </SearchContainer>


            <PostWrapper>
                {
                    posts.filter(post => post.profile.toLowerCase().includes(text.toLowerCase())).map(post=>(
                        <Card>
                            <CardContent>
                                <Typography variant ="h5">{post.profile}</Typography>
                                <Typography>{post.type ==="Offline" ? "Remote" :"Office"}</Typography>
                                <Typography>Salary: {post.salary}</Typography>
                                <Typography style = {{ color: '#6f6f6f', margin: '10px 0'}}
                                >{post.description.length>150? post.description.substring(0,150)+"...": post.description}</Typography>
                                <Typography><b>Experience</b>:{post.experience}</Typography>
                                <Typography><b>Technology</b>:{post.technology}</Typography>
                                <Typography
                                style = {{color: '#6f6f6f', marginTop: 'auto'}}
                                >posted on {new Date(post.createdAt).toLocaleDateString()}</Typography>
                            </CardContent>
                        </Card>
                    )
                    
                    )
                }
            </PostWrapper>
        </>
    
    )
}

export default AllPosts;