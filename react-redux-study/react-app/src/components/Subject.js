import {Component} from "react";

class Subject extends Component {
    render() {
        return (
            // render 안에서는 한개의 최상위 태그만 써야 한다.
            <header>
                <h1><a href="/" onClick={function (e) {
                    e.preventDefault();
                    this.props.onChangePage();
                }.bind(this)}>{this.props.title}</a></h1>
                {this.props.sub}
            </header>
        );
    }
}

export default Subject;