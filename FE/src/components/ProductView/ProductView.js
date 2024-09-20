import React, { useState, useEffect } from "react";
import { Container, Grid, Button, Typography } from "@material-ui/core";
import { Link } from "react-router-dom";
import { commerce } from "../../lib/commerce";
import "./style.css";

const createMarkup = (text) => {
  return { __html: text };
};

const ProductView = () => {
  const [product, setProduct] = useState({});

  const fetchProduct = async (id) => {
    try {
      const response = await commerce.products.retrieve(id);
      console.log({ response });

      const productData = response[0];

      const { bookName, bookDownload, authors } = productData;
      setProduct({
        name: bookName,
        src: bookDownload.bookIMG, 
        downloadLink: bookDownload.bookURL, 
        author: authors.authorName || "Unknown Author", 
        description: productData.description || "No description available", 
        price: productData.price ? productData.price.formatted_with_symbol : "N/A", // Thêm điều kiện cho giá
      });
    } catch (error) {
      console.error('Error fetching product:', error);
    }
  };

  useEffect(() => {
    const id = window.location.pathname.split("/")[2]; // Lấy id từ URL
    fetchProduct(id);
  }, []);

  return (
    <Container className="product-view">
      <Grid container>
        <Grid item xs={12} md={6} className="image-wrapper">
          <img src={product.src} alt={product.name} />
        </Grid>
        <Grid item xs={12} md={5} className="text">
          <Typography variant="h2">
            <b>{product.name}</b>
          </Typography>
          <Typography variant="h5">
            <b>Author: {product.author}</b>
          </Typography>
          <Typography
            variant="p"
            dangerouslySetInnerHTML={createMarkup(product.description)}
          />
          <Typography variant="h3" color="secondary">
            <a href={product.downloadLink}>Download</a>
          </Typography>
          <br />
          <Grid container spacing={0}>
            <Grid item xs={12}>
              <Button
                size="large"
                className="custom-button"
                component={Link}
                to="/"
              >
                See more books
              </Button>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </Container>
  );
};

export default ProductView;
