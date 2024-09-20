import React from "react";
import {
  Card,
  CardMedia,
  CardContent,
  CardActions,
  Typography,
  Button,
  CardActionArea,
} from "@material-ui/core";
import { AddShoppingCart } from "@material-ui/icons";
import { Link, useHistory } from "react-router-dom";
import useStyles from "./styles";

const Product = ({ product, onAddToCart }) => {
  const classes = useStyles();
  const history = useHistory();

  const handleClick = async () => {
    try {
      const response = await TodoService.getBook(product.name);
      
      console.log('API response:', response.data);

      history.push(`/product-view/${product.id}`);
    } catch (error) {
      console.error('Error calling API', error);
    }
  };


  return (
    <Card className={classes.root}>
        <CardActionArea onClick={handleClick}>
          <CardMedia
            className={classes.media}
            image={product.media.source}
            title={product.name}
          />
        </CardActionArea>
      <CardContent>
        <div className={classes.cardContent}>
          <p className={classes.cardContentName}> {product.name}</p>
        </div>
        <div className={classes.cardContent}>
          <p className={classes.cardContentPrice}>
            <b>{product.price.formatted_with_symbol}</b>
          </p>
        </div>
      </CardContent>
      <CardActions disableSpacing className={classes.cardActions}>
        <Button
          variant="contained"
          className={classes.button}
          endIcon={<AddShoppingCart />}
          onClick={() => onAddToCart(product.id, 1)}
        >
          <b onClick={handleClick}>VIEW DETAILS</b>
        </Button>
      </CardActions>
    </Card>
  );
};

export default Product;
